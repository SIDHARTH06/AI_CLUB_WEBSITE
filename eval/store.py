from flask import Blueprint,request,Flask, render_template,redirect,jsonify,Response
import json
import os 
import cv2
import numpy as np 
import zipfile
import datetime
import random 
store = Blueprint('store',__name__)
path = r"C:\Users\HP\Desktop\files\image_files"
pthScores = r'C:\Users\HP\Desktop\files\scores.json'
pthTime = r"C:\Users\HP\Desktop\files\time.json"
limit = 2
def evaluate(folder):
    score= random.random()
    return score

@store.route('/register',methods=['POST','GET'])
def register():
    if request.method=='POST':
        res = request.json
        f = open(pthScores)
        data = json.load(f)
        unames = []
        for i in data.values():
            unames.append(i[0])
        if res.get('id') in list(data.keys()) or res.get('uname') in unames:
            return jsonify({"body":"Already exists"})
        
        else:
            data[res.get('id')] = [res.get('uname'),0,limit,res.get('psw')]
            
        f.close()
        
        with open(pthScores, 'w') as fp:
            json.dump(data, fp)
        fp.close() 
        print("Registered")
        return jsonify({"body":"Registered"})
            
@store.route('/store',methods=['POST','GET'])
def home():
    if request.method=="POST":
        f = open(pthScores)
        data = json.load(f)
        if request.form.get('id') and request.form.get('password'):
            if request.form.get('id') in list(data.keys()):
                if request.form.get('password')==data[request.form.get('id')][3]:
                    if request.files:
                        zip= request.files['file']
                        if '.zip' in zip.filename:
                            if data.get(request.form.get('id'),-1)==-1:
                                return "Please register"
                            time = datetime.datetime.now()
                            f1=open(pthTime)
                            t=json.load(f1)
                            f1.close()
                            if t.get('day',-1)==-1:
                                t['month']=time.strftime("%m")
                                t['day'] = time.strftime("%d")
                                with open(pthTime, 'w') as fp:
                                    json.dump(t, fp) 
                                    
                            if time.strftime("%m")>t['month']:
                                data[request.form.get('id')][2]=limit
                                t['month']=time.strftime("%m")
                                t['day'] = time.strftime("%d")
                                with open(pthTime, 'w') as fp:
                                    json.dump(t, fp) 
                            elif time.strftime("%d")>t['day']:
                                data[request.form.get('id')][2]=limit
                                t['month']=time.strftime("%m")
                                t['day'] = time.strftime("%d")
                                with open(pthTime, 'w') as fp:
                                    json.dump(t, fp)
                                    
                            if data[request.form.get('id')][2]>0:
                                zip.save(os.path.join(path,zip.filename))
                                with zipfile.ZipFile(os.path.join(path,zip.filename),"r") as zipref:
                                    zipref.extractall(path)
                                os.remove(os.path.join(path,zip.filename))
                                folder= os.path.join(path,zip.filename.split('.')[0])
                                score=evaluate(folder)
                                if score>data[request.form.get('id')][1]:
                                    data[request.form.get('id')][1]=score
                                data[request.form.get('id')][2]-=1
                                f.close()
                                with open(pthScores, 'w') as fp:
                                    json.dump(data, fp)
                                fp.close()
                                
                                print("saved")
                                
                                return "Successfully submitted"
                            else:
                                return "Submission limit exceeded"
                        else: return "Not a zip file"
                    else: return "No file"
                else: return "incorrect password"
            else: return "please register"
        else: return "please fill details"
    else:
        return Response(400)
                
@store.route('/values',methods=['GET'])
def send_vals():
    f = open(pthScores)
    data = json.load(f)
    f.close()
    resp = dict()
    resp['body']=data
    res = jsonify(resp)
    print(resp)
    return res 

