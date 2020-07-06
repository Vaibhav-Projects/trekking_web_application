import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrekkingComponent } from './trekking.component';

describe('TrekkingComponent', () => {
  let component: TrekkingComponent;
  let fixture: ComponentFixture<TrekkingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrekkingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrekkingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
