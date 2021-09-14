from flask import Flask,request, render_template

def create_app():
    app = Flask(__name__)
    app.config['SECRET_KEY'] = 'jndennr'
    
    from .store import store
   
    
    app.register_blueprint(store,url_prefix='/v1')
    
    return app

