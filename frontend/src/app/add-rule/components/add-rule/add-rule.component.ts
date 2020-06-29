import { Component, OnInit } from '@angular/core';
import { AddRuleService } from '../../services/add-rule.service';
import { DRLFile } from 'src/app/models/drl-file.model';
import { MOVE_TYPES_PER_IMAGE } from '../../../shared/constants';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-rule',
  templateUrl: './add-rule.component.html',
  styleUrls: ['./add-rule.component.css']
})
export class AddRuleComponent implements OnInit {
  difficulties = ['beginner', 'intermediate', 'advanced'];
  seriousness = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  positions = [];

  drlFileName = '';
  ruleTitle = '';
  playerDifficulty = 'BEGINNER';
  playerSeriousness = 1;
  position1 = '';
  position2 = '';
  position3 = '';
  position4 = '';

  constructor(private addRuleService: AddRuleService,
              private toastr: ToastrService) { }

  ngOnInit() {
    this.positions = Array.from(Object.keys(MOVE_TYPES_PER_IMAGE));
    this.position1 = this.positions[0];
    this.position2 = this.positions[0];
    this.position3 = this.positions[0];
    this.position4 = this.positions[0];
  }

  saveDRLFile() {
    const drlFile = new DRLFile();
    drlFile.fileName = this.drlFileName;
    drlFile.ruleTitle = this.ruleTitle;
    drlFile.playerDifficulty = this.playerDifficulty;
    drlFile.playerSeriousness = this.playerSeriousness;
    drlFile.position1 = this.position1;
    drlFile.position2 = this.position2;
    drlFile.position3 = this.position3;
    drlFile.position4 = this.position4;

    console.log(drlFile);

    this.addRuleService.saveDRLFile(drlFile).subscribe((res: any) => {
      this.toastr.success('Rule successfully added');
      console.log('USPEH USPEH USPELI SMO JE');
    });
  }
}
