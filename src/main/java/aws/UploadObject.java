package aws;
import java.io.*;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;


public class UploadObject {
    public static void main(String[] args) {
        //String fileName = "./src/main/java/aws/test.txt";
        String fileName = "/Users/alexr/amtx.sql";
        String bucketName = "java-t1";
        //String stringObjKeyName = "object-2";
        String fileObjKeyName = "backup2";

        AWSCredentials credentials = new BasicAWSCredentials(
                "", ""
        );

        try {
            AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                    .withRegion(Regions.EU_CENTRAL_1)
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    //https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
                    .build();



            // Upload a text string as a new object.
            //s3.putObject(bucketName, stringObjKeyName, "Uploaded String Object");

            // Upload a file as a new object with ContentType and title specified.
            PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
            ObjectMetadata metadata = new ObjectMetadata();
            //metadata.setContentType("plain/text");
            //metadata.setContentType("plain/text");
            metadata.setContentEncoding("gzip");
            metadata.setContentType("application/x-gzip");
            //metadata.addUserMetadata("x-amz-meta-title", "someTitle");
            request.setMetadata(metadata);
            s3.putObject(request);
        }
        catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        }
        catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }


}

