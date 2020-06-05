import { Deserializable } from './deserializable.model';

export class DeterminePlayerType implements Deserializable {
    playerDifficulty: string;
    chosenMoveTypes: Array<string>;

    deserialize(input: any) {
        Object.assign(this, input);

        return this;
    }
}

