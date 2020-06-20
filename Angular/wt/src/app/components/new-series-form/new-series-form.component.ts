import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { SeriesService } from 'src/app/services/series.service';


@Component({
  selector: 'app-new-series-form',
  templateUrl: './new-series-form.component.html',
  styleUrls: ['./new-series-form.component.css'],
})
export class NewSeriesFormComponent implements OnInit {
  form : FormGroup;

  constructor(private seriesService : SeriesService) { }

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
    this.seriesService.addOrModifySeries({
      title: form.value.title,
      numberOfSeasons: form.value.seasons,
      genre: form.value.genre,
      streamingProvider: form.value.platform,
      score: form.value.rating,
      remark: form.value.remark
    })
  }
}
