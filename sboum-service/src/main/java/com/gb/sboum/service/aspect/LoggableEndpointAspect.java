package com.gb.sboum.service.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gb.sboum.utils.log.Loggable;
import com.gb.sboum.utils.log.LoggableAspectHelper;

/**
 * Logs method calls.
 *
 * <p>
 * It is an AspectJ aspect and you are not supposed to use it directly.
 *
 * @version $Id$
 */
@Aspect
public class LoggableEndpointAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggableEndpointAspect.class);

	private final Loggable.Level level = Loggable.Level.INFO;
	private final int limit = 1000;
	private final TimeUnit unit = TimeUnit.MILLISECONDS;
	private final int trim = 100;
	private final boolean prepend = false;
	private final boolean skipResult = false;
	private final boolean skipArgs = false;
	private final boolean logThis = false;
	private final int precision = 3;
	private final String name = "";

	@Autowired
	private LoggableAspectHelper logAspectHelper;

	/**
	 * Log endpoint methods.
	 *
	 * @param point
	 *            Joint point
	 * @return The result of call
	 * @throws Throwable
	 *             If something goes wrong inside
	 */
	@Around("execution(* com.gb.sboum.service.endpoint.*.*(..)) && " + "(@annotation(javax.ws.rs.GET) "
			+ "|| @annotation(javax.ws.rs.POST) " + "|| @annotation(javax.ws.rs.DELETE) "
			+ "|| @annotation(javax.ws.rs.PUT) " + "|| @annotation(javax.ws.rs.HEAD))")
	public Object wrapMethod(final ProceedingJoinPoint point) throws Throwable {
		LOGGER.debug("Log Endpoint: Start");
		final Method method = MethodSignature.class.cast(point.getSignature()).getMethod();
		return logAspectHelper.wrap(point, method, new Loggable() {

			@Override
			public Class<? extends Annotation> annotationType() {
				return Loggable.class;
			}

			@Override
			public Level value() {
				return level;
			}

			@Override
			public int limit() {
				return limit;
			}

			@Override
			public TimeUnit unit() {
				return unit;
			}

			@Override
			public int trim() {
				return trim;
			}

			@Override
			public boolean prepend() {
				return prepend;
			}

			@Override
			public Class<? extends Throwable>[] ignore() {
				return null;
			}

			@Override
			public boolean skipResult() {
				return skipResult;
			}

			@Override
			public boolean skipArgs() {
				return skipArgs;
			}

			@Override
			public boolean logThis() {
				return logThis;
			}

			@Override
			public int precision() {
				return precision;
			}

			@Override
			public String name() {
				return name;
			}

		});
	}

}
