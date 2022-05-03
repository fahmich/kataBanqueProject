import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class DataService {

    private operation$ = new BehaviorSubject<any>({});
    selectedOperation$ = this.operation$.asObservable();
    constructor() {}
  
    setOperation(operation: any) {
      this.operation$.next(operation);
      console.log("service",operation);
      
    }

}