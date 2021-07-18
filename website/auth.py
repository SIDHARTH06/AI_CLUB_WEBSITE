from flask import Blueprint,request, render_template

auth = Blueprint('auth',__name__)

@auth.route('/login',methods=['post','get'])
def login():
    name="varun sai"
    return render_template("login.html",text = name)

@auth.route('/logout')
def logout():
    return render_template("home.html")

@auth.route('/sign-up')
def signup():
    return render_template("signup.html")


