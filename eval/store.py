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

def evaluate(folder):
    score= random.random()
    return score

@store.route('/register',methods=['POST'])
def register():
    if request.method=='POST':
        f = open(r'C:\Users\HP\Desktop\files\scores.json',)
        data = json.load(f)
        if data.get(zip.filename.split('.')[0],-1)==-1:
            data[zip.filename.split('.')[0]]=[0,2]
        else:
            print("ALready registerd")
            
            
@store.route('/store',methods=['POST','GET'])
def home():
    if request.method=="POST":
        if request.files:
            zip= request.files['file']
            
            f = open(r"C:\Users\HP\Desktop\files\scores.json")
            data = json.load(f)
            
            if '.zip' in zip.filename:
                if data.get(zip.filename.split('.')[0],-1)==-1:
                    data[zip.filename.split('.')[0]]=[0,2]
                if data[zip.filename.split('.')[0]][1]>0:
                    print(zip)
                    zip.save(os.path.join(path,zip.filename))
                    with zipfile.ZipFile(os.path.join(path,zip.filename),"r") as zipref:
                        zipref.extractall(path)
                    os.remove(os.path.join(path,zip.filename))
                    folder= os.path.join(path,zip.filename.split('.')[0])
                    score=evaluate(folder)
                    if score>data[zip.filename.split('.')[0]][0]:
                        data[zip.filename.split('.')[0]][0]=score
                    data[zip.filename.split('.')[0]][1]-=1
                    f.close()
                    with open(r"C:\Users\HP\Desktop\files\scores.json", 'w') as fp:
                        json.dump(data, fp)
                    fp.close()
                    print(data)
                    print("Image saved")
                    
                    return redirect(request.url)
                
@store.route('/values',methods=['GET'])
def send_vals():
    f = open(r"C:\Users\HP\Desktop\files\scores.json")
    data = json.load(f)
    f.close()
    return data,200

