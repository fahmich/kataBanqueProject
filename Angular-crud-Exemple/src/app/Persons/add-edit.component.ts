import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import {  AlertService, DataService, PersonService } from '@app/_services';
import { MustMatch } from '@app/_helpers';

@Component({ templateUrl: 'add-edit.component.html' })
export class AddEditComponent implements OnInit {
    form: FormGroup;
    formulaire: FormGroup;
    id: string;
    isAddMode: boolean;
    loading = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private personService: PersonService,
        private alertService: AlertService,
        private data: DataService
    ) {}

    ngOnInit() {
        this.id = this.route.snapshot.params['id'];
        this.isAddMode = !this.id;
  
        
        this.formulaire = this.formBuilder.group({
            accountNumber : ['', Validators.required],
            operationAmount: ['', Validators.required],
         });
   
    }

    // convenience getter for easy access to form fields
    get f() { return this.formulaire.controls; }

    onSubmit() {
        this.submitted = true;
        // reset alerts on submit
        this.alertService.clear();
        // stop here if form is invalid
        if (this.formulaire.invalid) {
            return;
        }
        this.loading = true;
        if (this.isAddMode) {
            this.createPerson();
        } else {
            this.updatePerson();
        }
    }

    private createPerson() {
        console.log(this.formulaire.value);
        
        this.personService.create(this.formulaire.value)
            .pipe(first())
            .subscribe({
                next: () => {
                    this.alertService.success('Operartion success', { keepAfterRouteChange: true });
                    this.router.navigate(['../'], { relativeTo: this.route });
                },
                error: error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            });
    }

    private updatePerson() {
        this.personService.create( this.formulaire.value)
            .pipe(first())
            .subscribe({
                next: () => {
                    this.alertService.success('Person updated', { keepAfterRouteChange: true });
                    this.router.navigate(['../../'], { relativeTo: this.route });
                },
                error: error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            });
    }
}