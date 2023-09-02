import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewReviewComponent } from './view-review.component';

describe('ViewReviewComponent', () => {
  let component: ViewReviewComponent;
  let fixture: ComponentFixture<ViewReviewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewReviewComponent]
    });
    fixture = TestBed.createComponent(ViewReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
