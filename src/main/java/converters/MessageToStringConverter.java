
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.MessageActor;

@Component
@Transactional
public class MessageToStringConverter implements Converter<MessageActor, String> {

	@Override
	public String convert(MessageActor messageActor) {
		String result;

		if (messageActor == null)
			result = null;
		else
			result = String.valueOf(messageActor.getId());

		return result;
	}
}
