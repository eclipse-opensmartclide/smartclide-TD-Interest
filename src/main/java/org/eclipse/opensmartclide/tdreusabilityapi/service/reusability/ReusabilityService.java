package org.eclipse.opensmartclide.tdreusabilityapi.service.reusability;

import org.eclipse.opensmartclide.tdreusabilityapi.controller.reusability.entity.FileReusabilityIndex;
import org.eclipse.opensmartclide.tdreusabilityapi.controller.reusability.entity.ProjectReusabilityIndex;

import java.util.Collection;

/**
 * @author Dimitrios Zisis <zisisndimitris@gmail.com>
 *
 */
public interface ReusabilityService {

    Collection<FileReusabilityIndex> findReusabilityIndexByCommit(String url, String sha, Integer limit);

    Collection<FileReusabilityIndex> findReusabilityIndexByCommitAndFile(String url, String sha, String filePath);

    Collection<ProjectReusabilityIndex> findProjectReusabilityIndexByCommit(String url, String sha);

    Collection<ProjectReusabilityIndex> findProjectReusabilityIndexPerCommit(String url, Integer limit);

}
