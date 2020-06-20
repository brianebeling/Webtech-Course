import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SeriesService {

  constructor(private http: HttpClient) { }

  url = new URL("http://localhost:8080/steam/resources/");

  username: string;

  login(username : string, password : string)
  {
    return this.http.post(this.url + 'users/' + this.username + 'login', { password: password });
  }

  addOrModifySeries(seriesData: ISeriesData)
  {
    return this.http.post(this.url + 'series?username=' + this.username, seriesData);
  }
}

export interface ISeriesData
{
  title: string;
  season: number;
  genre: string;
  platform: string;
  rating: number;
  remark: string;
}
