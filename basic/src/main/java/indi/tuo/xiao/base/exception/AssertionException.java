package indi.tuo.xiao.base.exception;

import com.google.common.base.Strings;
import indi.tuo.xiao.base.assertion.IAssertion;
import indi.tuo.xiao.base.protocol.IResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

/**
 * Assertion exception
 */
@Getter
public class AssertionException extends BaseException {

  private static final String ASSERTION_ALL_MESSAGE = "The %s assertion %s failed";

  private static final String ASSERTION_FIELD_MESSAGE = "%s field %s assertion %s failed";

  private static final String SCRIPT_MESSAGE = "%s assertion failed";

  private static final String DETAIL_MESSAGE = "The result: %s failed %s";

  private List<String> messages;

  private IResponse response;

  public AssertionException(String scriptName, List<IAssertion> assertions, IResponse response) {
    super(Strings.lenientFormat(DETAIL_MESSAGE, response.toString(), assertions),
        new AssertionError(Strings.lenientFormat(SCRIPT_MESSAGE, scriptName)));
    this.messages = assertions.stream()
        .map(assertion -> {
          String fieldName = assertion.getFieldName();
          if (Strings.isNullOrEmpty(fieldName)) {
            return Strings
                .lenientFormat(ASSERTION_ALL_MESSAGE, assertion.name(), assertion.getExpression());
          } else {
            return Strings
                .lenientFormat(ASSERTION_FIELD_MESSAGE, assertion.getFieldName(), assertion.name(),
                    assertion.getExpression());
          }
        })
        .collect(Collectors.toList());
    this.response = response;
  }
}
