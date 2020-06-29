import { Deserializable } from './deserializable.model';

export class DRLFile implements Deserializable {
    fileName: string;
    ruleTitle: string;
    playerDifficulty: string;
    playerSeriousness: number;
    position1: string;
    position2: string;
    position3: string;
    position4: string;

    deserialize(input: any) {
        Object.assign(this, input);

        return this;
    }
}

