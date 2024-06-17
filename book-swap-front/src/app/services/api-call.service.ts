import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiCallService {

  constructor(private httpClient:HttpClient) { }
    
  getBookdetails(bookRequest: any): Observable<any> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Access-Control-Allow-Origin', '*'); 
    return this.httpClient.post(`http://localhost:9009/Book-Swap/getBook`, bookRequest);
  }

  getbookList(){
    return this.httpClient.get('http://localhost:9009/Book-Swap/allBooks');
  }
fetchOrderList(orderRequest:any)
{
return this.httpClient.post('http://localhost:9009/Book-Swap/order',orderRequest);
}
registerUser(UserData:any){
return this.httpClient.post('http://localhost:9009/user/save',UserData);
}
userlogin(Credential:any){
  return this.httpClient.post('http://localhost:9009/user/login',Credential);
  }

  addBook(book:any){
    return this.httpClient.post('http://localhost:8001/master/save',book);
    }
  
}
