import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerTestComponent } from './player-test.component';

describe('PlayerTestComponent', () => {
  let component: PlayerTestComponent;
  let fixture: ComponentFixture<PlayerTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayerTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
