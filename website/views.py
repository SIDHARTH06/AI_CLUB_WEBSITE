from flask import Blueprint,request, render_template

views = Blueprint('views',__name__)

@views.route('/')
def home():
    return render_template("home.html")

@views.route('/projects')
def showProject():
    return render_template('projects.html')

@views.route('/members')
def members():
    return render_template('members.html')