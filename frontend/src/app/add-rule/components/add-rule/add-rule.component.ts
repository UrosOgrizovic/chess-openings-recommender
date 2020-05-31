import { Component, OnInit } from '@angular/core';
import { AddRuleService } from '../../services/add-rule.service';

@Component({
  selector: 'app-add-rule',
  templateUrl: './add-rule.component.html',
  styleUrls: ['./add-rule.component.css']
})
export class AddRuleComponent implements OnInit {
  drlFileTitle = 'Placeholder file title';
  rule = `package drools.rules;\n\nagenda-group "Agenda-group name"\n\nrule "Rule name"\n    when\n        \n    then\n        \nend`;

  constructor(private addRuleService: AddRuleService) { }

  ngOnInit() {
  }

  saveDRLFile() {
    // console.log(this.drlFileTitle);
    // console.log(this.rule);
    this.addRuleService.saveDRLFile({title: this.drlFileTitle, content: this.rule}).subscribe((res: any) => {
      console.log('USPEH USPEH USPELI SMO JE');
    });
  }

  

}
