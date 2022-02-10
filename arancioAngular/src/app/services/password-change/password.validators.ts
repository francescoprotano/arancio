import { AbstractControl } from '@angular/forms';

export class PasswordValidators {
    

    static passwordsShouldMatch(control: AbstractControl) {
        let newPassword : any = control.get('newPassword');
        let confirmPassword : any = control.get('confirmPassword');

        if (newPassword.value !== confirmPassword.value)
            return { passwordsShouldMatch: true };
        
        return null;
    }



}