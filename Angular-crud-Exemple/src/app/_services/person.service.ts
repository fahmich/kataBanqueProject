import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import { environment } from '@environments/environment';
import { Person } from '@app/_models';
import { OperationInfo } from '@app/_models';

const baseUrl = `${environment.apiUrl}`;

@Injectable({ providedIn: 'root' })
export class PersonService {
    constructor(private http: HttpClient) { }

    getAll() {
       
        
        return this.http.get(`${baseUrl}/operations/ops`);
    }

    create(params:any) {
        console.log("this is ",params);
        
        return this.http.post(`${baseUrl}/operations/us12`, params);
    }
    getById(id: number) {
        return this.http.get(`${baseUrl}/operations/ops/${id}`);
    }
    getAllByAccount(numAccount:any){
        let params = new HttpParams();
        params = params.set('accountNumber', numAccount);
        return this.http.get(`${baseUrl}/operations/`,{params:{accountNumber: numAccount}});
    }
 

    // update(id: string, params) {
    //     return this.http.put(`${baseUrl}/${id}`, params);
    // }

    // delete(id: string) {
    //     return this.http.delete(`${baseUrl}/${id}`);
    // }

    
}