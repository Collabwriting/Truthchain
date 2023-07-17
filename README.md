<img width="250px" src="https://github.com/Collabwriting/Truthchain/assets/9627557/a70ccb1e-4fc1-4c12-a285-29d26585c4bd"/>

# Truthchain: Fighting Misinformation with Decentralized Truth Verification

Truthchain is an open-source project dedicated to combating misinformation and promoting truth in an increasingly digital and interconnected world. By harnessing the power of blockchain technology, data validators, and user contributions, Truthchain aims to create a decentralized platform where users can collect, verify, and store data, ensuring its authenticity and credibility.

## Key Features
**Data Collection**: Users can collect data from various online sources, such as news articles, social media posts, or websites, and submit it to Truthchain for verification.

**Data Verification**: Truthchain implements data verification by creating interfaces to other services, known as Data Validators, that can verify the submitted data. These Data Validators employ various techniques to assess the accuracy and credibility of the information.

**Digital Signatures**: Every piece of data that goes through Truthchain is digitally signed by the user who collected it. These digital signatures serve as proof of the data's origin and integrity.

**Blockchain Integration**: Truthchain leverages OriginTrail's ChatDKG, a Decentralized Knowledge Graph, for blockchain integration. Verified data, along with its metadata, is stored on the blockchain, creating an immutable and transparent record of verified information.

## How It Works
**Data Collection**: Users can use the Truthchain web interface or API to collect data they find online.

**Data Submission**: Once collected, users submit the data to Truthchain, along with relevant metadata, such as the source URL, date, and description. Users can also provide additional context or comments to aid the verification process.

**Data Verification**: Truthchain interfaces with Data Validators, that verifying specific types of data. These Data Validators apply their verification algorithms and techniques to assess the accuracy and credibility of the submitted information.

**Digital Signatures**: Once the data passes the verification stage, the user who collected it digitally signs the information. This cryptographic signature serves as a unique identifier and ensures the integrity and authenticity of the data.

**Blockchain Integration**: Verified and signed data, along with its metadata, is stored on the blockchain using OriginTrail's ChatDKG. ChatDKG provides a decentralized knowledge graph, ensuring the immutability and transparency of the verified data.

## Running Truthchain - `Coming Soon`
Truthchain is written in Java and can be easily run using Docker. Follow the steps below to run Truthchain:

1. Install Docker on your machine by following the instructions for your specific operating system: Docker Installation

2. Clone the Truthchain repository to your local machine:
``` bash
git clone https://github.com/Collabwriting/truthchain.git
```

3. Navigate to the Truthchain directory:
``` bash
cd truthchain
```

4. Build the Docker image:
``` bash
docker build -t truthchain .
```

5. Run Truthchain using Docker:
``` bash
docker run -p 3000:3000 truthchain
```

6. Access the Truthchain web interface by navigating to `http://localhost:3000` in your web browser.

## Contributing to Truthchain
Truthchain is an open-source project, and we welcome contributions from developers, designers, and enthusiasts who share our mission of combating misinformation. If you're interested in contributing, please follow these steps:
1. Fork the Truthchain repository on GitHub.
2. Create a new branch for your contributions.
3. Make the necessary changes and improvements.
4. Test your changes to ensure they work as expected.
5. Commit your changes and submit a pull request.
Our team will review your contribution, provide feedback if necessary, and merge it into the main repository once approved.

## License
Truthchain is released under the [GPL-3.0 License](https://github.com/Collabwriting/Truthchain/blob/main/LICENSE). Feel free to use, modify, and distribute the software in accordance with the terms and conditions of the license.

## Acknowledgments
The **OriginTrail** team's expertise in blockchain technology and their commitment to building decentralized solutions have been instrumental in helping Truthchain create a reliable and transparent system for storing verified data. The integration of ChatDKG into Truthchain's architecture has enhanced the immutability and tamper-proof nature of our platform, ensuring that the verified data remains secure and accessible.

## Contact Us
If you have any questions, suggestions, or feedback, please don't hesitate to reach out to us. You can contact the Truthchain team at contact@truthchain.dev or join our community on Discord.

Join us in the fight against misinformation and help build a more informed world with Truthchain! Together, we can make a difference.
