package demo.converter;

import demo.models.PhoneNumberModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * StringToPhoneNumberConverter
 *
 * @author jt_hu
 * @date 2018/5/21
 */
public class StringToPhoneNumberConverter implements Converter<String, PhoneNumberModel> {

    private static final String SPLIT_CHAR = "-";

    @Override
    public PhoneNumberModel convert(String s) {
        if (!StringUtils.hasText(s)) {
            return null;
        }

        if (s.contains(SPLIT_CHAR)) {
            String[] strings = s.split(SPLIT_CHAR);

            PhoneNumberModel phoneNumberModel = new PhoneNumberModel();
            phoneNumberModel.setAreaCode(strings[0]);
            phoneNumberModel.setNumber(strings[1]);

            return phoneNumberModel;
        }

        return null;
    }

}
