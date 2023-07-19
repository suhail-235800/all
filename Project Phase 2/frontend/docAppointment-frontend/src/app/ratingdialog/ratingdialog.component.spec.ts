import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RatingdialogComponent } from './ratingdialog.component';

describe('RatingdialogComponent', () => {
  let component: RatingdialogComponent;
  let fixture: ComponentFixture<RatingdialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RatingdialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RatingdialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
