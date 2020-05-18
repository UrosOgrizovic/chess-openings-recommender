import { Deserializable } from './deserializable.model';

export class PlayerPreferences implements Deserializable {
    playerDifficulty: string;
    playerSeriousness: number;
    imgPaths: Array<string>;

    deserialize(input: any) {
        Object.assign(this, input);

        return this;
    }
}

