import { Component, OnInit } from '@angular/core';
import { SeriesService } from 'src/app/services/series.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-series-added-notify',
  templateUrl: './series-added-notify.component.html',
  styleUrls: ['./series-added-notify.component.css']
})
export class SeriesAddedNotifyComponent implements OnInit {

  form: FormGroup;

  userName:string;
  userPassword:string;
  public show:boolean = true;

  constructor(private seriesService : SeriesService) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      userName: new FormControl(),
      userPassword: new FormControl()
    })
  }

  onSubmit(form: FormGroup) {
    this.seriesService.login(form.value.userName, form.value.userPassword).subscribe((res) => {
      if (res.ok)
      {
        this.show=false;
      }
    });  
  }
}
