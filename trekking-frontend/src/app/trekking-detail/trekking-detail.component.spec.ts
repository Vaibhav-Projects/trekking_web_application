import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrekkingDetailComponent } from './trekking-detail.component';

describe('TrekkingDetailComponent', () => {
  let component: TrekkingDetailComponent;
  let fixture: ComponentFixture<TrekkingDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrekkingDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrekkingDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
