import { Component } from '@angular/core';

@Component({
  selector: 'app-adminbody',
  templateUrl: './adminbody.component.html',
  styleUrls: ['./adminbody.component.css']
})
export class AdminbodyComponent {
  doctors: any[] = [
    { name: 'Aleena', specialization: 'Cardiology', location: 'Ernakulam', isEditing: false },
    { name: 'Suhail', specialization: 'Orthology', location: 'Ernakulam', isEditing: false },
    { name: 'lydia', specialization: 'Dental', location: 'Ernakulam', isEditing: false }
  ];

  toggleEdit(doctor: any) {
    doctor.isEditing = !doctor.isEditing;
  }

    this.doctors.splice(index, 1);
  }

}
