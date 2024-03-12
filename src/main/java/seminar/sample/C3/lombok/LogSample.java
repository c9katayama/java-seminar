package seminar.sample.C3.lombok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogSample {

	//private final Logger log = LoggerFactory.getLogger(LogSample.class);

	public static void main(String[] args) {
		log.info("hoge");
	}
}
