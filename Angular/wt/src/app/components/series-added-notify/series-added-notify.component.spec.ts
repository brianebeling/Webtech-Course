import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeriesAddedNotifyComponent } from './series-added-notify.component';

describe('SeriesAddedNotifyComponent', () => {
  let component: SeriesAddedNotifyComponent;
  let fixture: ComponentFixture<SeriesAddedNotifyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeriesAddedNotifyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeriesAddedNotifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
