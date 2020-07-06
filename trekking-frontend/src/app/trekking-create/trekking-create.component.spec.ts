import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrekkingCreateComponent } from './trekking-create.component';

describe('TrekkingCreateComponent', () => {
  let component: TrekkingCreateComponent;
  let fixture: ComponentFixture<TrekkingCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrekkingCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrekkingCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
