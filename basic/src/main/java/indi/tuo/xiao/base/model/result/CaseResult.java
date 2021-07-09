package indi.tuo.xiao.base.model.result;

import java.time.Instant;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * case result
 */
@Data
@ToString
@NoArgsConstructor
public class CaseResult {

  /**
   * replay record id
   */
  private String recordId;

  /**
   * case section result, key is sample name
   */
  private Map<String, SampleResult> sampleResults;

  /**
   * The response time of each transaction, in milliseconds
   */
  private Map<String, Integer> transResults;

  /**
   * timestamp
   */
  private Instant ts;

  public CaseResult(String recordId,
      Map<String, SampleResult> sampleResults,
      Map<String, Integer> transResults) {
    this.recordId = recordId;
    this.sampleResults = sampleResults;
    this.transResults = transResults;
    this.ts = Instant.now();
  }
}
