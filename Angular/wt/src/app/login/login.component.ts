import { Component, OnInit } from '@angular/core';
import { SeriesService } from 'src/app/services/series.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

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

  public Sign(form: FormGroup) {
    this.seriesService.login(form.value.userName, form.value.userPassword).subscribe((res) => {
      if (res.ok)
      {
        this.show=false;
      }
    });  
  }

  public OpenForm()
  {
    this.show = true;
  }

  public CloseForm()
  {
    this.show = false;
  }
}
