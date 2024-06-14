import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface Credential {
    email: string;
    password: string;
}


@Injectable({ providedIn: 'root' })
export class ApiHttpService {
    private readonly _http = inject(HttpClient);
    private url:string="http://localhost:8080";


//    registerFirebaseRequest(email: string, password: string):Observable<any> {



        //return this._http.post("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyAXlT6w6Sk-5IChMmXdmELmzPyL6vTtZKk", { "email": email, "password": password, "returnSecuredToken": true })
    
        

  //  }



    registerUser(email: string, username: string, nombre: string, apellidos: string, password: string):Observable<any> {
        return this._http.post(this.url+"/usuario/crearUsuario", {
            'username': username,
            'email': email,
            'nombre': nombre,
            'apellidos': apellidos,
            'password': password
        })
    }

      //  loginFirebaseRequest(email: string, password: string):Observable<any>  {

      //  return this._http.post("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyAXlT6w6Sk-5IChMmXdmELmzPyL6vTtZKk", {
       //     'email': email,
       //     'password': password,
       //     'returnSecuredToken': true
       // })
  //  }

    loginUser(email:string,password:string):Observable<any> {
        return this._http.post(this.url+"/usuario/login",{
            "email":email,
            "password":password
        })
    }

    getUsuarioByEmail(email: string, token: string):Observable<any> {
        return this._http.get(this.url+"/usuario/email/".concat(email))
    }

    getUsuarioById(usuario_id: string, token: string):Observable<any> {
        return this._http.get(this.url+"/usuario/id/".concat(usuario_id+""))
    }

    getSalasPublicas(token: string) :Observable<any>{
        return this._http.get(this.url+"/salas/publicas")
    }

    crearSalaPublica(nombre: string, descripcion: string, topicos: Array<string>, usuario_id: string, token: string):Observable<any> {
        return this._http.post(this.url+"/sala/crearSalaPublica", {
            "sala": {
                "nombre": nombre,
                "descripcion": descripcion,
                "topicos": topicos,
            },
            "usuario_id": usuario_id
        })
    }


    joinSalaPublica(id:string,nombre:string,descripcion:string,privacidad:string,participantes:Array<any>,topicos:Array<any>,usuario_id: string,token:string):Observable<any>{
        return this._http.post(this.url+"/sala/publica/join",{
            "salaPublica":{
                "id":id,
                "nombre":nombre,
                "descripcion":descripcion,
                "privacidad":privacidad,
                "participantes":participantes,
                "topicos":topicos        
            },
            "usuario_id": usuario_id
        })
    }

    leaveSalaPublica(id:string,nombre:string,descripcion:string,privacidad:string,participantes:Array<any>,topicos:Array<any>,usuario_id: string,token:string):Observable<any>{
        return this._http.post(this.url+"/sala/publica/leave",{
            "salaPublica":{
                "id":id,
                "nombre":nombre,
                "descripcion":descripcion,
                "privacidad":privacidad,
                "participantes":participantes,
                "topicos":topicos        
            },
            "usuario_id": usuario_id
        })
    }

    getSalasPrivadasFiltro(nombre:string,token:string):Observable<any>{
        return this._http.get(this.url+"/salas/privadas/filtro/".concat(nombre))
    }

    getSalaById(sala_id:string,token:string):Observable<any>{
        return this._http.get(this.url+"/sala/id/".concat(sala_id))
    }

    crearSalaPrivada(nombre: string, descripcion: string,password:string, topicos: Array<string>, usuario_id: string, token: string):Observable<any> {
        return this._http.post(this.url+"/sala/crearSalaPrivada", {
            "salaPrivadaDTO": {
                "nombre": nombre,
                "descripcion": descripcion,
                "password":password,
                "topicos": topicos,
            },
            "usuario_id": usuario_id
        })
    }

    joinSalaPrivada(sala_id:string,usuario_id: string,password:string,token:string):Observable<any>{
        return this._http.post(this.url+"/sala/privada/join",{
            "salaPrivada_id":sala_id,
            "usuario_id": usuario_id,
            "password":password
        })
    }


    getAllTopicos(token:string):Observable<any>{
        return this._http.get(this.url+"/topics/lista")
    }

    getTopicosSala(sala_id:string,token:string){
        return this._http.get(this.url+"/topics/sala/".concat(""+sala_id))
    }

    crearTopico(nombre:string,usuario_id:string,token:string):Observable<any>{
        return this._http.post(this.url+"/topics/crearTopico",{
            "topico_nombre":nombre,
            "usuario_id":usuario_id
        })
    }

    eliminarTopico(nombre:string,usuario_id:string,token:string):Observable<any>{
        return this._http.post(this.url+"/topics/eliminarTopico",{
            "topico_nombre":nombre,
            "usuario_id":usuario_id
        })
    }

    updateUsuario(usuario_id:string,email: string, username: string, nombre: string, apellidos: string,token:string):Observable<any>{
        return this._http.post(this.url+"/usuario/updateProfile",{
            "usuario_id":usuario_id,
            "usuarioDTO":{
                "username":username,
                "email":email,
                "nombre":nombre,
                "apellidos":apellidos
            }
        })
    }

    makeModerator(usuario_id:string,admin_id:string,token:string):Observable<any>{
        return this._http.post(this.url+"/usuario/makeModerator",{
            "usuario_id":usuario_id,
            "admin_id":admin_id
        })
    }

    deleteModerator(usuario_id:string,admin_id:string,token:string):Observable<any>{
        return this._http.post(this.url+"/usuario/deleteModerator",{
            "usuario_id":usuario_id,
            "admin_id":admin_id
        })
    }

    getListaUsuario(token:string):Observable<any>{
        return this._http.get(this.url+"/usuarios/lista")
    }

    getListaModerators(token:string):Observable<any>{
        return this._http.get(this.url+"/usuarios/listaMods")
    }

    getSalaByUsuario(username:string,token:string):Observable<any>{
        return this._http.get(this.url+"/".concat(username.concat("/salas")))
    }

    eliminarSala(sala_id:string,token:string):Observable<any>{
        return this._http.post(this.url+"/sala/deleteSala", {
            "sala_id":sala_id
        })
    }

    makeSalaPrivate(sala_id:string,password:string,token:string):Observable<any>{
        return this._http.post(this.url+"/sala/makePrivate",{
            "sala_id":sala_id,
            "password":password
        })
    }

    makeSalaPublic(sala_id:string,token:string):Observable<any>{
        return this._http.post(this.url+"/sala/makePublic",{
            "sala_id":sala_id
        })
    }

    changeDescripcionSala(sala_id:string,descripcion:string,token:string):Observable<any>{
        return this._http.post(this.url+"/sala/descripcion",{
            "sala_id":sala_id,
            "descripcion":descripcion
        })
    }

    changeNombreSala(sala_id:string,nombre:string,token:string):Observable<any>{
        return this._http.post(this.url+"/sala/nombre",{
            "sala_id":sala_id,
            "nombre":nombre
        })
    }

    getMessagesSala(locale:string,sala_id:string, token:string):Observable<any>{
        return this._http.get(this.url+"/chat/get/".concat(locale.concat("/".concat(sala_id+""))))
    }

    sendMessageSala(sala_id:string,mensaje:string,date:Date,usuario_id:string, token:string):Observable<any> {
        return this._http.post(this.url+"/chat/send",{
            "sala_id":sala_id,
            "mensajeDTO":{
                "mensaje":mensaje,
                "date":date
            },
            "usuario_id":usuario_id
        })
    }

}