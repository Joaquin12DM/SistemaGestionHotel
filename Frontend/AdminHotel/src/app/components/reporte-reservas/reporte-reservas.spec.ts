import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteReservas } from './reporte-reservas';

describe('ReporteReservas', () => {
  let component: ReporteReservas;
  let fixture: ComponentFixture<ReporteReservas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReporteReservas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReporteReservas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
