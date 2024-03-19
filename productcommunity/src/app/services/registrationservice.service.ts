import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BehaviorSubject, Subject } from 'rxjs';
import { User } from '../Class/user';
import { HttpClient } from '@angular/common/http'
import { Product } from '../Class/product';
import { Review } from '../Class/review';
import { Admin } from '../Class/admin';
@Injectable({
  providedIn: 'root'
})
export class RegistrationserviceService {
  member!: string;
  constructor(private http: HttpClient) { }
  public loginUserFromRemote(user: User): Observable<any> {
    return this.http.post<any>("http://localhost:9090/loginuser", user);
  }
  public registerUserFromRemote(user: User): Observable<any> {
    return this.http.post<any>("http://localhost:9090/registeruser", user);
  }
  setName(name: any) {
    window.localStorage.setItem("name", name);
  }
  getName() {
    return window.localStorage.getItem("name");
  }
  setId(id: any) {
    window.localStorage.setItem("id", id);
  }
  getId() {
    return window.localStorage.getItem("id");
  }

  public getAllProductFromRemote(): Observable<any> {
    return this.http.get<any>("http://localhost:9090/welcome/product");
  }
  public getAllUserFromRemote(): Observable<any> {
    return this.http.get<any>("http://localhost:9090/user");
  }

  public getSearchProductFromRemote(data: any): Observable<any> {
    return this.http.get<any>("http://localhost:9090/search?query=" + data);
  }
  public getReviewOnProductFromRemote(data: any): Observable<any> {
    return this.http.get<any>("http://localhost:9090/review?query2=" + data);
  }
  public PostReviewToRemote(review: Review): Observable<any> {
    return this.http.post<any>("http://localhost:9090/postreview", review);
  }
  public getAvgReview(data: any): Observable<any> {
    return this.http.get<any>("http://localhost:9090/avgreview?query3=" + data);
  }
  public getAllReviewFromRemote(): Observable<any> {
    return this.http.get<any>("http://localhost:9090/allreview");
  }
  public loginadminFromRemote(admin: Admin): Observable<any> {
    return this.http.post<any>("http://localhost:9090/loginadmin", admin);
  }
  public updateReviewStatusOnRemote(serialNo:any): Observable<any> {
    return this.http.get<any>("http://localhost:9090/updatestatus?serialNo="+serialNo);
  }
  public rejectReviewStatusOnRemote(serialNo:any): Observable<any> {
    return this.http.get<any>("http://localhost:9090/rejectstatus?serialNo="+serialNo);
  }
}
