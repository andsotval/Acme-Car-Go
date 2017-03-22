
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import repositories.OfferOrRequestRepository;
import domain.OfferOrRequest;

@Component
@Transactional
public class StringToOfferOrRequestConverter implements Converter<String, OfferOrRequest> {

	@Autowired
	OfferOrRequestRepository	offerOrRequestRepository;


	@Override
	public OfferOrRequest convert(String text) {
		OfferOrRequest result;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = offerOrRequestRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
