import { log } from './log.mjs';
import { S3 } from '@aws-sdk/client-s3';

const s3Client = new S3({region: 'us-east-1'});

export const handler = async(event) => {

    const record = event.Records[0];
    const Bucket = record.s3.bucket.name;
    const Key = record.s3.object.key;
   
    const getObjectResult = await s3Client.getObject({
	Bucket,
	Key
    });

    // Get bytes number of the object and convert to kb and mb
    const mega_byte = 1024 * 1024;

    if (getObjectResult.ContentLength > 1 * mega_byte) {
        log('Huge object ...');
	return 'Huge object';
    }
    log('Object size OK');
    return 'Object size OK';
};
