package cc.redpen.validator.sentence;

import cc.redpen.model.Sentence;
import cc.redpen.validator.Validator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HankakuAlphabetValidator extends Validator {
    private static Pattern pat = Pattern.compile("(?!\\\\)[a-zA-Z]+");

    @Override
    public void validate(Sentence sentence) {
        Matcher re = pat.matcher(sentence.getContent());
        while (re.find()) {
            this.addLocalizedErrorWithPosition(
                sentence, re.start(), re.end(), re.group()
            );
        }
    }
}
