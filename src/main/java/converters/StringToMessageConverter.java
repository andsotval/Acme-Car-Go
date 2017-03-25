
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import repositories.MessageRepository;
import domain.MessageActor;

@Component
@Transactional
public class StringToMessageConverter implements Converter<String, MessageActor> {

	@Autowired
	MessageRepository	messageRepository;


	@Override
	public MessageActor convert(String text) {
		MessageActor result;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = messageRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
