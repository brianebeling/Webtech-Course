import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewSeriesFormComponent } from './new-series-form.component';

describe('NewSeriesFormComponent', () => {
  let component: NewSeriesFormComponent;
  let fixture: ComponentFixture<NewSeriesFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewSeriesFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewSeriesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
