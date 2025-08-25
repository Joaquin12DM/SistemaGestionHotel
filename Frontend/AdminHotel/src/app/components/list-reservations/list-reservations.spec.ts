import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListReservations } from './list-reservations';

describe('ListReservations', () => {
  let component: ListReservations;
  let fixture: ComponentFixture<ListReservations>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListReservations]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListReservations);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
