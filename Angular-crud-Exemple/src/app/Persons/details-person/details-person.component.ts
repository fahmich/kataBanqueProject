import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PersonService } from '@app/_services/person.service';
import { Person } from '@app/_models';
import { OperationInfo } from '@app/_models';
import { first } from 'rxjs/operators';
import { DataService } from '@app/_services/Data.Service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-details-person',
  templateUrl: './details-person.component.html',
  styleUrls: ['./details-person.component.less']
})
export class DetailsPersonComponent implements OnInit {
 accountDetails:any;
 persons:any
message:string;
subscription: Subscription;
  constructor( 
    public route: ActivatedRoute,
    private personService: PersonService,
    private data: DataService
    ) { }
    OperationInfo:OperationInfo=new OperationInfo()
    numAccount:any;
  ngOnInit()  {
    this.data.selectedOperation$.subscribe((value) => {
      this.accountDetails = value;} )

    console.log("ffff",this.accountDetails)
    this.route.params.subscribe(param => {     
        console.log(param['id'])
    
        this.personService.getById(param['id'])
        .pipe(first())
        .subscribe((numAccount) => 
          {
            this.numAccount= numAccount ;
              console.log(numAccount);



              this.personService.getAllByAccount(this.numAccount)
              .pipe(first())
              .subscribe((p) => {
                  this.persons =p 
                  console.log(p);
                  
                 });
           } );
    })


 
    }

  

}
