import { FormGroup, ValidationErrors } from '@angular/forms';

export function HasCheckedBox(formGroup: FormGroup): ValidationErrors | null {
  let hasCheckedBox = false;

  for (let innerFormGroup of Object.values(formGroup.controls!)) {
    if ((innerFormGroup as FormGroup).controls['checked'].value === true) {
      hasCheckedBox = true;
    }
  }

  if (!hasCheckedBox) {
    return { mustHaveCheckedBox: true };
  }
  return null;
}
