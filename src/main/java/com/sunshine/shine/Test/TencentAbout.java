package com.sunshine.shine.Test;

public class TencentAbout {
//    /*
//     *目前用于上传教师头像，教师课时费，课时费模板，班级类型模板
//     */
//    public static String uploadFile(MultipartFile image, String key) {
//
//        ConfigUtils configUtils = new ConfigUtils();
//        // 1 初始化用户身份信息(secretId, secretKey)
//        COSCredentials cred = new BasicCOSCredentials(configUtils.get("conf", "q_secretId"), configUtils.get("conf", "q_secretKey"));
//        // 2 设置bucket的区域, COS地域的简称请参照
//        // https://cloud.tencent.com/document/product/436/6224
//        ClientConfig clientConfig = new ClientConfig(new Region(configUtils.get("conf", "q_region")));
//        // 3 生成cos客户端
//        COSClient cosClient = new COSClient(cred, clientConfig);
//        String bucketName = configUtils.get("conf", "q_bucketName");
//        log.info("file key:{}", key);
//        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
//        // 大文件上传请参照 API 文档高级 API 上传
//        // 指定要上传到 COS 上的路径
//        //file = new File("/Users/jiangfeng/Desktop/123.doc");
//        ObjectMetadata objectMetadata = new ObjectMetadata();
//        objectMetadata.setContentType(image.getContentType());
//        objectMetadata.setContentLength(image.getSize());
//        // 设置 Content type, 默认是 application/octet-stream
//        try {
//            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, image.getInputStream(), objectMetadata);
//            log.info("PutObjectRequest:{}", putObjectRequest);
//            PutObjectResult result = cosClient.putObject(putObjectRequest);
//            cosClient.shutdown();
//        } catch (IOException e) {
//            return "";
//        }
//        Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
//        URL url = cosClient.generatePresignedUrl(bucketName, key, expiration);
//        log.info("file url : {}, {}", url.getFile(), url.getPath());
//        return url.getPath();
//    }
}
