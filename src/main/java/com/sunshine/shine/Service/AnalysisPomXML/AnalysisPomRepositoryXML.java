package com.sunshine.shine.Service.AnalysisPomXML;

public class AnalysisPomRepositoryXML {
    private static final char PATH_SEPARATOR = '/';
    private static final char GROUP_SEPARATOR = '.';
    private static final char ARTIFACT_SEPARATOR = '-';

//    public String pathOf(Artifact artifact) {
//        ArtifactHandler artifactHandler = artifact.getArtifactHandler();
//        StringBuilder path = new StringBuilder(128);
//        path.append(formatAsDirectory(artifact.getGroupId())).append(PATH_SEPARATOR);
//        path.append(artifact.getArtifactId()).append(PATH_SEPARATOR);
//        path.append(artifact.getBaseVersion()).append(PATH_SEPARATOR);
//        path.append(artifact.ArtifactId()).append(ARTIFACT_SEPARATOR).append(artifact.getVersion());
//
//        if (artifact.hasClassifier()) {
//            path.append(ARTIFACT_SEPARATOR).append(artifact.getClassifier());
//        }
//
//        if (artifactHandler.getExtension() != null && artifactHandler.getExtension().length() > 0) {
//            path.append(GROUP_SEPARATOR).append(artifactHandler.getExtension());
//        }
//        return "";
//    }
//
//    private String formatAsDirectory(String directory) {
//        return directory.replace(GROUP_SEPARATOR, PATH_SEPARATOR);
//    }
}
