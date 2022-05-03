import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { PersonService } from '@app/_services/person.service';
import { Router } from '@angular/router';
import { DataService } from '@app/_services/Data.Service';
import { Subscription } from 'rxjs';

 
@Component({ templateUrl: 'list.component.html' })
export class ListComponent implements OnInit {
    persons = null;
    accountDetails:any;
    message:string;
    subscription: Subscription;
    constructor(private personService: PersonService,
        private data: DataService,
        private router: Router ) {}

    ngOnInit() {
        this.personService.getAll()
            .pipe(first())
            .subscribe((p) => {
                this.persons =p 
                console.log(p);
                
               });
    }
 
    redirectTo(person:any ) {
        this.accountDetails=person;
        console.log( this.accountDetails); 
            this.data.setOperation(this.accountDetails);
           
        this.router.navigate(['/detail/'+person.operationId ])        
      
    }
}