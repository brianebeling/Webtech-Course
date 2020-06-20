import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-new-series-form',
  templateUrl: './new-series-form.component.html',
  styleUrls: ['./new-series-form.component.css'],
})
export class NewSeriesFormComponent implements OnInit {
  form : FormGroup;

  constructor() { }

  ngOnInit(): void {
    this.form = new FormGroup({
      title: new FormControl(),
      seasons: new FormControl(),
      genre: new FormControl(),
      platform: new FormControl(),
      rating: new FormControl(),
      remark: new FormControl
    })
  }

  onSubmit(form: FormGroup) {
    console.log('Valid?', form.valid); // true or false
    console.log('Name', form.value.name);
    console.log('Email', form.value.email);
    console.log('Message', form.value.message);
  }
}
