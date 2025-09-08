#!/bin/bash

echo "🔧 Setting up AI Assistant Project..."
cd "$(dirname "$0")/.."

# Create keystore.properties if not exists
if [ ! -f "keystore.properties" ]; then
    echo " Creating keystore.properties..."
    cat > keystore.properties << EOF
storeFile=keystore.jks
storePassword=your_password_123
keyAlias=ai_assistant
keyPassword=your_password_123
EOF
    echo "⚠️ Please edit keystore.properties with your actual values"
fi

# Create google-services directory if not exists
mkdir -p app/google-services

echo "✅ Setup completed!"
echo "📁 Project structure is ready"
echo "🚀 Run: ./gradlew assembleDebug to build"
