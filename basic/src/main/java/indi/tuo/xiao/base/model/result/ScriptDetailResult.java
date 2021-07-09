package indi.tuo.xiao.base.model.result;

import indi.tuo.xiao.base.model.enums.CaseSection;
import indi.tuo.xiao.base.protocol.IResponse;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Detailed playback results of the script
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ScriptDetailResult implements Serializable {

  private CaseSection caseSection;

  private List<IResponse> responses;
}