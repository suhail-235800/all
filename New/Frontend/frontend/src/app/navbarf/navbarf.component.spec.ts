import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarfComponent } from './navbarf.component';

describe('NavbarfComponent', () => {
  let component: NavbarfComponent;
  let fixture: ComponentFixture<NavbarfComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavbarfComponent]
    });
    fixture = TestBed.createComponent(NavbarfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
